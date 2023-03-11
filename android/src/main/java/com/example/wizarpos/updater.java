// package net.mastarjeta.wizarposQ2;

// import java.io.File;
// import java.io.FileInputStream;

// import android.os.Environment;
// import android.net.Uri;


// import android.app.DownloadManager;
// import android.app.Activity;
// import android.content.Context;
// import android.content.Intent;
// import android.content.BroadcastReceiver;
// import android.content.IntentFilter;
// import android.content.IntentSender;
// import android.app.PendingIntent;


// public class UpdateApp extends AsyncTask<String,Void,Void>{
//     private Context context; 
//     public void setContext(Context contextf){ 
//         context = contextf; 
//     }

//     @Override
//     protected void doInBackground(String... apkurl){
//         try { 
//             URL url = new URL(apkurl[0]); 
//             HttpURLConnection c = (HttpURLConnection) url.openConnection(); 
//             c.setRequestMethod("GET"); 
//             c.setDoOutput(true); 
//             c.connect();

//             String PATH = Environment.getExternalStorageDirectory() + "/download/"; 
//             File file = new File(PATH); 
//             file.mkdirs(); 
//             File outputFile = new File(file, "largadistancia.apk"); 
//             if(outputFile.exists()){ 
//                 outputFile.delete(); 
//             }
//             FileOutputStream fos = new FileOutputStream(outputFile); 
            
//             InputStream is = c.getInputStream(); 
            
//             byte[] buffer = new byte[1024]; 
//             int len1 = 0; 
//             while ((len1 = is.read(buffer)) != -1) { 
//                 fos.write(buffer, 0, len1); 
//             } 
//             fos.close(); 
//             is.close();
//             intent.setDataAndType(Uri.fromFile(new File(Environment.getExternalStorageDirectory() + "/download/" + "largadistancia.apk")), "application/vnd.android.package-archive"); 
//             intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK); 
//             startActivity(intent);
//         } catch (IOException e) { 
//         //     Toast.makeText(getApplicationContext(), "Update error!", Toast.LENGTH_LONG).show(); 
//         } 
//     }
// }

// // atualizaApp = new UpdateApp(); atualizaApp.setContext(getApplicationContext()); atualizaApp.execute("http://serverurl/appfile.apk");
