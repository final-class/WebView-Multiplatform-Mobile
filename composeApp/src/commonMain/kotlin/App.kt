import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.final_class.webview_multiplatform_mobile.library.WebViewPlatform
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun App() {
    MaterialTheme {
        var openWebView by remember {
            mutableStateOf(false)
        }
        var url by remember {
            mutableStateOf("https://github.com/final-class/WebView-Multiplatform-Mobile")
        }

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 40.dp),
                text = "WebView Multiplatform Mobile",
                fontSize = 18.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.SemiBold
            )

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 40.dp, start = 20.dp, end = 20.dp),
                value = url,
                onValueChange = { url = it },
                label = { Text("Url") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Uri, imeAction = ImeAction.Done),
            )

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.White)
                    .padding(top = 20.dp, start = 20.dp, end = 20.dp),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary),
                onClick = { url = "" }
            ) {
                Text(
                    text = "Clear URL",
                    color = Color.Black
                )
            }

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp, start = 20.dp, end = 20.dp),
                shape = RoundedCornerShape(16.dp),
                onClick = { openWebView = true }
            ) {
                Text("Open WebView")
            }
        }

        if (openWebView) {
            openWebView = false

            WebViewPlatform(
                url = url
            )
        }
    }
}

@Preview
@Composable
fun AppPreview() {
    App()
}