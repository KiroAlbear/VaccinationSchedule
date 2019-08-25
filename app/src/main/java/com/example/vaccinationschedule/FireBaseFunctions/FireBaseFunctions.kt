package com.example.powerofwords2.BasicFunctions

import android.app.Activity
import android.content.Context
import android.util.Log
import com.example.powerofwords2.Navigators.FireBaseNavigator
import com.example.vaccinationschedule.FireBaseFunctions.fireBaseStrings
import com.example.vaccinationschedule.Model.CurrentUserEntity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.database.DataSnapshot


class FireBaseFunctions(fireBaseNavigator: FireBaseNavigator, context: Context) {
    private val fireStore: FirebaseFirestore

    private val fireBaseNavigator: FireBaseNavigator
    private var auth: FirebaseAuth
    private var realTimeDataBase: DatabaseReference
    private lateinit var database: FirebaseDatabase
    private val context: Context

    init {
        fireStore = FirebaseFirestore.getInstance()
        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()
        realTimeDataBase = database.reference

        this.fireBaseNavigator = fireBaseNavigator
        this.context = context
    }

    private fun addUser(currentUser: CurrentUserEntity) {
        val fireBaseUser = hashMapOf(
            fireBaseStrings.full_email to currentUser.full_email,
            fireBaseStrings.e_username to currentUser.e_username,
            fireBaseStrings.e_domain to currentUser.e_domain,
            fireBaseStrings.e_tld to currentUser.e_tld,
            fireBaseStrings.e_punycode to currentUser.e_punycode
        )

        val db = FirebaseFirestore.getInstance()
        db.collection("users").document(currentUser.full_email).set(fireBaseUser)
            .addOnSuccessListener { documentReference ->
                fireBaseNavigator.onSuccessAdingUserData(currentUser.full_email)
                //  Log.d("adding currentUser", documentReference.toString())

            }.addOnFailureListener { ex ->
                fireBaseNavigator.onFailedAdingUserData()
            }

    }


    fun getUsreByProperty( propertyName:String, value:String){
        val db = FirebaseFirestore.getInstance()
        db.collection(fireBaseStrings.COLLECTION_NAME).whereEqualTo(propertyName, value)
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {

                }
            }
            .addOnFailureListener { exception ->
                print(exception)
            }
    }


    fun getAllUsers() {
        fireStore.collection("users")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    var temp = document.get("learnedWords")
                    print(temp)
                }
            }
            .addOnFailureListener { exception ->
                print(exception)
            }
    }

//
//    fun insertChildToUser(email: String, emailType: String, word: String) {
//        fireStore.collection("users").document(email)
//            .update(IntentKeys.USER_FIRESTORE_LEARNEDWORDS_KEY, FieldValue.arrayUnion(word))
//    }


    fun getRealTimeWordsData() {
        realTimeDataBase.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {
                Log.d("realTime", "Failed to read value.", p0.toException())
            }

            override fun onDataChange(p0: DataSnapshot) {

                val friends = arrayListOf<String?>()
                for (ds in p0.getChildren()) {
                    val friend: String = ds.value.toString()
                    friends.add(friend)
                }


            }
        })
    }

    fun signUpUser(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // Sign up success, update UI with the signed-in user's information
                    fireBaseNavigator.onSuccessRegisterUser()

                } else {

                }

                // ...
            }.addOnFailureListener { exception ->
                fireBaseNavigator.onFailRegisterUser(exception.toString())
            }.addOnCanceledListener {

            }.addOnSuccessListener {

            }

    }

    fun validateEmail(email: String) {


    }

    fun signInUser(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    fireBaseNavigator.onSuccessSignInUser()

                } else {
                    fireBaseNavigator.onFailSignInUser()
                }


            }.addOnFailureListener { exception ->

            }
    }

    fun signInUserWithEmail(email: String): Boolean {
        return auth.isSignInWithEmailLink(email)
    }

//    fun signInUserWithGmail() {
//        var mGoogleSignInClient = GoogleSignIn.getClient(context, gso)
//        val signInIntent = mGoogleSignInClient.signInIntent
//        startActivityForResult(context as Activity, signInIntent, 0, null)
//    }

//    fun signoutGmailUser() {
//        var mGoogleSignInClient = GoogleSignIn.getClient(context, gso)
//        mGoogleSignInClient.signOut()
//    }

//    fun firebaseAuthWithGoogle(acct: GoogleSignInAccount) {
//        val credential = GoogleAuthProvider.getCredential(acct.idToken, null)
//        checkUserExistance(
//            CurrentUserEntity(
//                acct.displayName!!,
//                acct.email!!,
//                arrayListOf(),
//                IntentKeys.USER_SIGNED_GMAIL_VALUE
//            )
//        )
//    }


    fun signOutUser() {
        FirebaseAuth.getInstance().signOut()
    }

    fun isUserCurrentlySignedIn(): Boolean {
        val currentUser = auth.currentUser
        return currentUser != null
    }


    fun getUserByEmail(userEmail: String) {
        fireStore.collection("users").document(userEmail).get().addOnSuccessListener { documents ->

            //            for (document in documents) {
//                    currentUser = CurrentUserEntity(
//                        document.get(IntentKeys.USER_FIRESTORE_NAME_KEY) as String,
//                        document.get(IntentKeys.USER_FIRESTORE_EMAIL_KEY) as String,
//                        document.get(IntentKeys.USER_FIRESTORE_LEARNEDWORDS_KEY) as ArrayList<String>,
//                        document.get(IntentKeys.USER_FIRESTORE_EMAILTYPE_KEY) as String
//                    )
//
//                }
            val currentUser = CurrentUserEntity(
                documents.get(fireBaseStrings.full_email) as String,
                documents.get(fireBaseStrings.e_username) as String,
                documents.get(fireBaseStrings.e_tld) as String,
                documents.get(fireBaseStrings.e_punycode) as String,
                documents.get(fireBaseStrings.e_language) as String,
                documents.get(fireBaseStrings.e_domain) as String
            )
            fireBaseNavigator.onGettingUserByEmail(currentUser)
        }.addOnFailureListener { exception ->
            fireBaseNavigator.onUserNotFound()
        }
    }

    fun insertUser(user: CurrentUserEntity) {
        addUser(user)
    }

    fun checkUserExistance(user: CurrentUserEntity) {
        fireStore.collection("users").document(user.full_email)
            .get().addOnSuccessListener { response ->
                if (response.data == null)
                    fireBaseNavigator.onUserNotFound()
                else
                    fireBaseNavigator.onGettingUserByEmail(user)
            }
            .addOnFailureListener { ex ->
            }
    }

}