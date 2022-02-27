package com.mycompany.app;

import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

 

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Hello world!
 *
 */
public class App {
    static Logger logger = Logger.getLogger("com.mycompany.app");

    static {
        BasicConfigurator.configure();
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
        logger.info("Hello World!");
    }

    public void analyze(String uri) throws IOException {
        Path path = FileSystems.getDefault().getPath(uri);
        List<String> words = Files.readAllLines(path);

        // Count all the characters frequencies:
        final Map<Character, Long> frequency = words.stream()
                .flatMapToInt(w -> w.chars())
                .mapToObj(i -> (char) i)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()));
        // Sort the characters by frequency and print:
        frequency.entrySet().stream()
                .sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue()))
                .forEach(entry -> logger.info(entry.getKey() + " " + entry.getValue()));
    }

    public void parseWiki() throws IOException {
        Document doc = (Document) Jsoup.connect("https://en.wikipedia.org/").get();
        logger.info(((org.jsoup.nodes.Document) doc).title());
        Elements newsHeadlines = doc.select("#mp-itn b a");
        for (Element headline : newsHeadlines) {
            logger.info(headline.attr("title") + "\n\t" + headline.absUrl("href"));
        }
    }
}
