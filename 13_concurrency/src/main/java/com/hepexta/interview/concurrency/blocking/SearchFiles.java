package com.hepexta.interview.concurrency.blocking;

import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class SearchFiles {
    private static int N_CONSUMERS = 10;

    public static void main(String[] args) {
        startIndexing(new File[] {
                new File("C:\\Users\\Sergei_Kuznetsov1\\Work\\Projects\\interview\\java-interview\\13_concurrency\\src\\main\\java\\com\\hepexta\\interview"),
                new File("C:\\Users\\Sergei_Kuznetsov1\\Work\\Projects\\interview\\java-interview\\01_codingtasks\\src\\main\\java\\com\\hepexta\\interview"),
        });
    }

    public static void startIndexing(File[] roots) {
        BlockingQueue<File> queue = new LinkedBlockingQueue<>(10);
        FileFilter filter = file -> true;
        for (File root : roots)
            new Thread(new FileCrawler(queue, filter, root)).start();
        for (int i = 0; i < N_CONSUMERS; i++)
            new Thread(new Indexer(queue)).start();
    }
}
