// package com.example.Database;
//
// import android.os.Bundle;
// import android.support.design.widget.FloatingActionButton;
// import android.support.design.widget.Snackbar;
// import android.support.v7.app.AppCompatActivity;
// import android.support.v7.widget.Toolbar;
// import android.util.Log;
// import android.view.Menu;
// import android.view.MenuItem;
// import android.view.View;
//
// import com.example.m.aplikacja_screen.R;
//
// public class MainActivity extends AppCompatActivity {
//     private static final String TAG = "MainActivity";
//
//     public static final String PATH = "/sdcard/Download/";
//
//     @Override
//     protected void onCreate(Bundle savedInstanceState) {
//         super.onCreate(savedInstanceState);
//         setContentView(R.layout.activity_main);
//         Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//         setSupportActionBar(toolbar);
//
//         // TODO zrobic metody statyczne? czy moze singletona?
//
//         Database db = new Database(getContentResolver());
//
//         // TODO potworzyc widoki
//         // TODO potworzyc funkcje wybierajace dane z tabel
//         // TODO zrobic pozostale updaty
//         // TODO zrobic pozostale delete
//
//         // loadFromExcelFile(contentResolver, "Test.xls");
//
//         Log.e(TAG, "onCreate: " + db.getQuestionById(2));
//         Log.e(TAG, "onCreate: " + db.getQuestionById(4));
//
//         FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//         fab.setOnClickListener(new View.OnClickListener() {
//             @Override
//             public void onClick(View view) {
//                 Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                         .setAction("Action", null).show();
//             }
//         });
//     }
//
//     @Override
//     public boolean onCreateOptionsMenu(Menu menu) {
//         // // Inflate the menu; this adds items to the action bar if it is present.
//         // getMenuInflater().inflate(R.menu.menu_main, menu);
//         // return true;
//     }
//
//     @Override
//     public boolean onOptionsItemSelected(MenuItem item) {
//         // Handle action bar item clicks here. The action bar will
//         // automatically handle clicks on the Home/Up button, so long
//         // as you specify a parent activity in AndroidManifest.xml.
//         int id = item.getItemId();
//
//         //noinspection SimplifiableIfStatement
//         if (id == R.id.action_settings) {
//             return true;
//         }
//
//         return super.onOptionsItemSelected(item);
//     }
//
// }
