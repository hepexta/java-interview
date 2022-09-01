package com.hepexta.interview.concurrency.blocking;

import lombok.RequiredArgsConstructor;

import java.io.File;
import java.io.FileFilter;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArraySet;

@RequiredArgsConstructor
public class FileCrawler implements Runnable {
    private final BlockingQueue<File> fileQueue;
    private final FileFilter fileFilter;
    private final File root;
    private final Set<File> cache = new CopyOnWriteArraySet<>();

    public void run() {
        try {
            crawl(root);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void crawl(File root) throws InterruptedException {
        File[] entries = root.listFiles(fileFilter);
        if (entries != null) {
            for (File entry : entries)
                if (entry.isDirectory())
                    crawl(entry);
                else if (!alreadyIndexed(entry)) {
                    cache.add(entry);
                    fileQueue.put(entry);
                }
        }
    }

    private boolean alreadyIndexed(File entry) {
        return cache.contains(entry);
    }
}