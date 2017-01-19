package com.inet.Abraj_English;

import android.os.Bundle;
import android.util.Log;

import com.adamrosenfield.wordswithcrosses.WordsWithCrossesActivity;

import com.inet.myapplication.R;

public class CrossWords extends WordsWithCrossesActivity {
//
//    /** Number of threads which are currently downloading puzzles */
//    private int downloadingThreads = 0;
//
//    public NotificationManager getNotificationManager() {
//        return nm;
//    }
//
//
//    /**
//     * Posts a message to this object to render on the UI thread
//     */
//    public void postRenderMessage() {
//        handler.post(new Runnable() {
//            public void run() {
//                //CrossWords.this.render();
//            }
//        });
//    }
//
//
//    private boolean needDatabaseSync() {
//        long folderTimestamp = WordsWithCrossesApplication.CROSSWORDS_DIR.lastModified();
//        long lastDBSync = prefs.getLong(PREF_LAST_DB_SYNC_TIME, 0);
//        return (folderTimestamp > lastDBSync);
//    }
//
//
//
//    private void downloadStarterPuzzles() {
//        new Thread(new Runnable() {
//            public void run() {
//                CrossWords.this.internalDownloadStarterPuzzles();
//            }
//        }).start();
//    }
//
//    private void internalDownloadStarterPuzzles() {
//        synchronized (this) {
//            downloadingThreads++;
//        }
//
//        Downloaders dls = new Downloaders(this, false);
//        dls.enableIndividualDownloadNotifications(false);
//
//        Calendar now = Calendar.getInstance();
//
//        for (int i = 0; i < 7; i++) {
//            Calendar date = (Calendar)now.clone();
//            date.add(Calendar.DAY_OF_MONTH, -i);
//            dls.download(date);
//
//            postRenderMessage();
//        }
//
//        synchronized (this) {
//            downloadingThreads--;
//        }
//    }
//
//    private void step_1(){
//
//
//        if (!WordsWithCrossesApplication.getDatabaseHelper().hasAnyPuzzles() &&
//                TextUtils.isEmpty(prefs.getString("welcome_shown_release", "")))
//        {
//            // If this is the first time the user has launched the app, start
//            // downloading a bunch of starter puzzles and show the welcome
//            // page
//            if (WordsWithCrossesApplication.makeDirs()) {
//                updateLastDatabaseSyncTime();
//                downloadStarterPuzzles();
//            }
//
//            // Also don't show the the release notes the first time the user
//            // launched the app
//            try {
//                PackageInfo pkgInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
//
//                SharedPreferences.Editor e = prefs.edit();
//                e.putString("welcome_shown_release", pkgInfo.versionName);
//                e.commit();
//            } catch(PackageManager.NameNotFoundException e) {
//                e.printStackTrace();
//            }
//
//            showWelcomePage();
//        } else {
//            // Look up what the latest version of the app is which has shown
//            // the welcome screen
//            boolean showReleaseNotes = false;
//            try {
//                PackageInfo pkgInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
//
//                String welcomeShownRelease = prefs.getString("welcome_shown_release", "");
//                if (!welcomeShownRelease.equals(pkgInfo.versionName)) {
//                    showReleaseNotes = true;
//
//                    SharedPreferences.Editor e = prefs.edit();
//                    e.putString("welcome_shown_release", pkgInfo.versionName);
//                    e.commit();
//                }
//            } catch(PackageManager.NameNotFoundException e) {
//                e.printStackTrace();
//            }
//
//            if (showReleaseNotes) {
//                // Show the release notes if this is the first time the user
//                // launched this version of the app
//                showHTMLPage("release.html");
//            } else if (needDatabaseSync()) {
//                // If there are files in the crosswords directory which aren't
//                // known in the database, sync the database with the file
//                // system (on a background thread)
//                new Thread(new Runnable() {
//                    public void run() {
//                        syncDatabase();
//                    }
//                }).start();
//            } else {
//                // Normal case -- database is in sync and user has launched this
//                // version before.  Try to download new puzzles if necessary.
//                render();
//                checkDownload();
//            }
//        }
//
//
//    }
//
//    private void internalDownload(Calendar date, List<Downloader> downloaders) {
//        synchronized (this) {
//            downloadingThreads++;
//        }
//
//        com.adamrosenfield.wordswithcrosses.net.Downloaders dls = new com.adamrosenfield.wordswithcrosses.net.Downloaders(this, false);
//        dls.download(date, downloaders);
//
//        synchronized (this) {
//            downloadingThreads--;
//        }
//
//        postRenderMessage();
//    }
//
//    private void download(final Calendar date, final List<Downloader> downloaders) {
//        new Thread(new Runnable() {
//            public void run() {
//                CrossWords.this.internalDownload(date, downloaders);
//            }
//        }).start();
//    }
//
//    private void checkDownload() {
//        synchronized (this) {
//            if (downloadingThreads > 0) {
//                // No automatic downloads while other downloads are pending
//                return;
//            }
//        }
//        long lastDL = prefs.getLong("dlLast", 0);
//
//        if (prefs.getBoolean("dlOnStartup", true) &&
//                ((System.currentTimeMillis() - (long) (12 * 60 * 60 * 1000)) > lastDL)) {
//            this.download(Calendar.getInstance(), null);
//            prefs.edit()
//                    .putLong("dlLast", System.currentTimeMillis())
//                    .commit();
//        }
//    }
//
//
//    private void syncDatabase() {
//        long startTime = System.currentTimeMillis();
//
//        // Get the list of .puz files in the crosswords directory
//        File[] fileList = WordsWithCrossesApplication.CROSSWORDS_DIR.listFiles(
//                new FilenameFilter() {
//                    public boolean accept(File dir, String name) {
//                        return name.endsWith(".puz");
//                    }
//                });
//        if (fileList == null) {
//            LOG.warning("Unable to enumerate directory: " + WordsWithCrossesApplication.CROSSWORDS_DIR);
//            return;
//        }
//
//        // Sort the list of filenames
//        ArrayList<String> filenameList = new ArrayList<>(fileList.length);
//        for (File file : fileList) {
//            filenameList.add(file.getAbsolutePath());
//        }
//        Collections.sort(
//                filenameList,
//                new Comparator<String>() {
//                    public int compare(String s1, String s2) {
//                        return s1.compareTo(s2);
//                    }
//                });
//
//        // Get the list of filenames in the database
//        PuzzleDatabaseHelper dbHelper = WordsWithCrossesApplication.getDatabaseHelper();
//        List<PuzzleDatabaseHelper.IDAndFilename> dbFileList = dbHelper.getFilenameList();
//
//        ArrayList<String> filesToAdd = new ArrayList<>();
//        ArrayList<Long> filesToRemove = new ArrayList<>();
//
//        // Pseudo-merge the two sorted lists to reconcile them
//        int filenameIndex = 0;
//        int dbIndex = 0;
//        while (filenameIndex < filenameList.size() && dbIndex < dbFileList.size()) {
//            int cmp = filenameList.get(filenameIndex).compareTo(dbFileList.get(dbIndex).filename);
//            if (cmp == 0) {
//                // File exists in both the file system and database, we're good
//                filenameIndex++;
//                dbIndex++;
//            } else if (cmp < 0) {
//                // File exists in the file system but not in the database, so
//                // add it to the database
//                filesToAdd.add(filenameList.get(filenameIndex));
//                filenameIndex++;
//            } else {
//                // File exists in the database but not in the file system, so
//                // remove it from the database
//                filesToRemove.add(dbFileList.get(dbIndex).id);
//                dbIndex++;
//            }
//        }
//
//        while (filenameIndex < filenameList.size()) {
//            filesToAdd.add(filenameList.get(filenameIndex));
//            filenameIndex++;
//        }
//
//        while (dbIndex < dbFileList.size()) {
//            filesToRemove.add(dbFileList.get(dbIndex).id);
//            dbIndex++;
//        }
//
//        // Update the database accordingly
//        String source = getResources().getString(com.adamrosenfield.wordswithcrosses.R.string.source_unknown);
//        for (String filename : filesToAdd) {
//            File file = new File(filename);
//            dbHelper.addPuzzle(file, source, "", file.lastModified());
//        }
//
//        dbHelper.removePuzzles(filesToRemove);
//
//        updateLastDatabaseSyncTime();
//
//        long durationMs = System.currentTimeMillis() - startTime;
//        LOG.info("Database sync took " + durationMs + " ms");
//
//        postRenderMessage();
//    }
//

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cross_words);

        Log.w("bbbbbbbbbbbbbbbbbbbbbbb","Bbbb");
    }
}
