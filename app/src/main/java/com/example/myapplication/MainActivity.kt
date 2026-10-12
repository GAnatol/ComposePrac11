package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.keepScreenOn
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                MainApp()
            }
        }
    }
}


val Poppins = FontFamily(
    Font(R.font.poppins_regular, FontWeight.Normal),
    Font(R.font.poppins_semibold, FontWeight.SemiBold),
    Font(R.font.poppins_bold, FontWeight.Bold),
    Font(R.font.poppins_medium, FontWeight.Medium)
)

@Composable
fun MainApp() {
    var screen by rememberSaveable { mutableStateOf(0) }

    when (screen) {
        0 -> WelcomeScreen(
            onOpenLogin = { screen = 1},
            onOpenRegister = { screen = 2 }
        )
        1 -> LoginScreen(
            onOpenRegister = {screen = 2},
            onOpenWelcome = {screen = 0}
        )
        2 -> RegisterScreen(
            onOpenLogin = { screen = 1 },
            onOpenWelcome = { screen = 0 }
        )
    }
}

@Composable
fun WelcomeScreen(onOpenLogin: () -> Unit, onOpenRegister: () -> Unit) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.height(50.dp))

            Image(
        painter = painterResource(id = R.drawable.welcome_image),
        contentDescription = "freelancer with laptop"
    )

        Column(

        ) {
            Text(
                "Discover Your\nDream Job here",
                fontFamily = Poppins,
                fontWeight = FontWeight.SemiBold,
                fontSize = 35.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
                lineHeight = 55.sp,
                color = Color(0xFF1F41BB)
            )

            Spacer(Modifier.height(23.dp))

            Text(
                "Explore alll the existing job roles based on your\n" +
                        "interest and study major",
                fontFamily = Poppins,
                fontWeight = FontWeight.Normal,
                fontSize = 13.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
            )
        }
        Spacer(Modifier.height(88.dp))

        Row(
            modifier = Modifier.padding(horizontal = 39.dp)
        ) {
            Button(
                onClick = onOpenLogin,
                modifier = Modifier.fillMaxWidth().height(60.dp).weight(1f),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(Color(0xFF1F41BB))
            ) {
                Text(
                    "Login",
                    fontFamily = Poppins,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 20.sp
                    )
            }

            Spacer(Modifier.width(30.dp))

            Button(
                onClick = onOpenRegister,
                modifier = Modifier.fillMaxWidth().height(60.dp).weight(1f),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(Color.White)

                ) {
                Text(
                    "Register",
                    fontFamily = Poppins,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 20.sp,
                    color = Color.Black
                )
            }
        }
    }
}

@Composable
fun LoginScreen(onOpenRegister: () -> Unit, onOpenWelcome: () -> Unit) {
    Column(
        modifier = Modifier.padding(start = 30.dp, end = 41.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.height(97.dp))

        Text(
            "Login here",
            fontFamily = Poppins,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            color = Color(0xFF1F41BB)
        )

        Spacer(Modifier.height(26.dp))

        Text(
            "Welcome back you’ve\n" +
                    "been missed!",
            textAlign = TextAlign.Center,
            fontFamily = Poppins,
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp
        )

        Spacer(Modifier.height(74.dp))

        OutlinedTextField(
            value = "",
            onValueChange = {},
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text("Email") },
            shape = RoundedCornerShape(size = 10.dp),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = Color(0xFF1F41BB),
                focusedBorderColor = Color(0xFF1F41BB)
            )
        )

        Spacer(Modifier.height(29.dp))

        OutlinedTextField(
            value = "",
            onValueChange = {},
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text("Password") },
            shape = RoundedCornerShape(size = 10.dp),
            singleLine = true
        )

        Spacer(Modifier.height(30.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth(),
            contentAlignment = Alignment.CenterEnd
        ) {
            Text(
                "Forgot your password?",
                modifier = Modifier.clickable(
                    onClick = onOpenWelcome
                ),
                fontFamily = Poppins,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF1F41BB)
            )
        }

        Spacer(Modifier.height(30.dp))

        Button(
            onClick = onOpenWelcome,
            modifier = Modifier.fillMaxWidth().height(60.dp),
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(
                Color(0xFF1F41BB)
            )
        ) {
            Text(
                "Sign in",
                fontFamily = Poppins,
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp
            )
        }

        Spacer(Modifier.height(30.dp))

        Button(
            onClick = onOpenRegister,
            modifier = Modifier.fillMaxWidth().height(41.dp),
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(
                Color.White
            )
        ) {
            Text(
                "Create new account",
                fontFamily = Poppins,
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp,
                color = Color(0xFF494949)
            )
        }

        Spacer(Modifier.height(65.dp))

        Text(
            "Or continue with",
            fontFamily = Poppins,
            fontWeight = FontWeight.SemiBold,
            fontSize = 14.sp,
            color = Color(0xFF1F41BB)
        )

        Spacer(Modifier.height(20.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.google),
                contentDescription = "google"
            )

            Image(
                painter = painterResource(id = R.drawable.facebook),
                contentDescription = "facebook"
            )

            Image(
                painter = painterResource(id = R.drawable.apple),
                contentDescription = "apple"
            )
        }
    }
}

@Composable
fun RegisterScreen(onOpenLogin: () -> Unit, onOpenWelcome: () -> Unit) {
    Column(
        modifier = Modifier.padding(start = 30.dp, end = 41.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.height(97.dp))

        Text(
            "Create Account",
            fontFamily = Poppins,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            color = Color(0xFF1F41BB)
        )
        Text(
            "Create an account so you can explore all the existing jobs",
            textAlign = TextAlign.Center,
            fontFamily = Poppins,
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp
        )
        Spacer(Modifier.height(53.dp))

        OutlinedTextField(
            value = "",
            onValueChange = {},
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text("Email") },
            shape = RoundedCornerShape(size = 10.dp),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = Color(0xFF1F41BB),
                focusedBorderColor = Color(0xFF1F41BB)
            )
        )

        Spacer(Modifier.height(26.dp))

        OutlinedTextField(
            value = "",
            onValueChange = {},
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text("Password") },
            shape = RoundedCornerShape(size = 10.dp),
            singleLine = true
        )

        Spacer(Modifier.height(26.dp))

        OutlinedTextField(
            value = "",
            onValueChange = {},
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text("Confirm Password") },
            shape = RoundedCornerShape(size = 10.dp),
            singleLine = true
        )

        Spacer(Modifier.height(53.dp))

        Button(
            onClick = onOpenWelcome,
            modifier = Modifier.fillMaxWidth().height(60.dp),
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(
                Color(0xFF1F41BB)
            )
        ) {
            Text(
                "Sign up",
                fontFamily = Poppins,
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp
            )
        }

        Spacer(Modifier.height(30.dp))

        Button(
            onClick = onOpenLogin,
            modifier = Modifier.fillMaxWidth().height(41.dp),
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(
                Color.White
            )
        ) {
            Text(
                "Already have an account",
                fontFamily = Poppins,
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp,
                color = Color(0xFF494949)
            )
        }

        Spacer(Modifier.height(65.dp))

        Text(
            "Or continue with",
            fontFamily = Poppins,
            fontWeight = FontWeight.SemiBold,
            fontSize = 14.sp,
            color = Color(0xFF1F41BB)
        )

        Spacer(Modifier.height(20.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.google),
                contentDescription = "google"
            )

            Image(
                painter = painterResource(id = R.drawable.facebook),
                contentDescription = "facebook"
            )

            Image(
                painter = painterResource(id = R.drawable.apple),
                contentDescription = "apple"
            )
        }
    }
}


@Preview(
    showBackground = true,
    widthDp = 428,
    heightDp = 926
)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
    }
}