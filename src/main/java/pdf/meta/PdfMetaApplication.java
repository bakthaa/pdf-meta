package pdf.meta;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.pdfbox.io.RandomAccessFile;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.pdmodel.documentinterchange.logicalstructure.PDMarkInfo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author power-team
 *
 */
@SpringBootApplication
@RestController
public class PdfMetaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PdfMetaApplication.class, args);
//		try {
//			List<FileMeta> f = getFiles("/Users/power-team/Downloads");
////			f.stream().forEach(System.out::println);
//		} catch (InvalidFolder e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	@PostMapping(path = "/info", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.ACCEPTED)
	@CrossOrigin
	public Result getInfo(@RequestBody Result arg) throws InvalidFolder {

		System.out.println(arg);
		final Result result = new Result();

		result.setFiles(getFiles(arg.getFolderName()));
		return result;
	}

	private static List<FileMeta> getFiles(final String folderName) throws InvalidFolder {

		final File folder = new File(folderName);
		if (!folder.isDirectory()) {

			throw new InvalidFolder("Folder Not Found");
		}
		final File[] pdfFiles = folder.listFiles(f -> f.getName().toLowerCase().endsWith("pdf"));
		if (0 == pdfFiles.length) {
			throw new InvalidFolder("File(s} Not Found");
		}
		return Arrays.asList(pdfFiles).stream().map(PdfMetaApplication::getFileMeta).collect(Collectors.toList());
	}

	private static FileMeta getFileMeta(File file) {

		try {
			final FileMeta meta = new FileMeta(file.getName());
			if (file.exists()) {
				try (RandomAccessFile pdfIStream = new RandomAccessFile(file, "r")) {

					final PDFParser pdfParser = new PDFParser(pdfIStream);
					pdfParser.parse();
					try (final PDDocument pdDoc = new PDDocument(pdfParser.getDocument())) {

						final PDDocumentInformation info = pdDoc.getDocumentInformation();
						final String title = (null != info) ? info.getTitle() : "No";
						meta.setTitle(title);

						final PDDocumentCatalog cat = pdDoc.getDocumentCatalog();
						if (null != cat) {

							meta.setLan(cat.getLanguage());
							final PDMarkInfo markInfo = cat.getMarkInfo();
							final String tagged = (null != markInfo) ? "" + markInfo.isMarked() : "No";
							meta.setTagged(tagged);
						}
					}
				}
			}
			return meta;
		} catch (IOException e) {

			e.printStackTrace();
			return null;
		}

	}

}
