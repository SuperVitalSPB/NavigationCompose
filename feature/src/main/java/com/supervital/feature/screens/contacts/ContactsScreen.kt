package com.supervital.feature.screens.contacts

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun ContactsScreen() {
    Text(text = "ddddddddddddddd")
}
/*
    val owner = LocalViewModelStoreOwner.current

    owner?.let {
        val viewModel: UserViewModel = viewModel(
            it,
            "UserViewModel",
            UserViewModelFactory(LocalContext.current.applicationContext as Application)
        )
        Main(viewModel)
    }
}

@Composable
fun Main(vm: UserViewModel) {
    val userList by vm.userList.observeAsState(listOf())
    val isUserNameExists by vm.foundUsers.observeAsState( false)
    var name by remember { vm.userName }
    var resultCheck by remember { vm.resultCheck }

    val focusRequester = remember { FocusRequester() }

    Column {
        OutlinedTextField(
            value = name,
            label = { Text("Name") },
            modifier = Modifier
                .padding(8.dp)
                .focusRequester(focusRequester),
            onValueChange = { vm.changeName(it) },
            isError = isUserNameExists,
            supportingText = {
                if (isUserNameExists) {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = vm.getStringUserNameExists,
                        color = MaterialTheme.colorScheme.error
                    )
                }
            }
        )
        Row {
            OutlinedTextField(
                value = vm.userAge.value,
                label = { Text("Age") },
                modifier = Modifier
                    .padding(8.dp)
                    .weight(0.5F),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                ),
                onValueChange = { vm.changeAge(it) }
            )

            Button(
                onClick = {
                    vm.apply {
                        addUser()
                        userName.value = ""
                        userAge.value = ""
                        checkData()
                        focusRequester.requestFocus()
                    }
                },
                enabled = resultCheck is ResultCheck.ResultOk,
                modifier = Modifier
                    .padding(8.dp)
                    .weight(0.3F)
                    .align(Alignment.Bottom),
            ) {
                Text(
                    text = "Add",
                    fontSize = 24.sp
                )
            }
        }
        UserList(
            users = userList,
            delete = { vm.deleteUser(it) }
        )

    }
}

@Composable
fun UserList(users: List<User>,
             delete: (Int) -> Unit) {
    UserTitleRow()
    LazyColumn(
        modifier =  Modifier.fillMaxWidth()
    ) {
        items(users) {
                user -> UserRow(user) { delete(user.id) }
        }
    }
}

@Composable
fun UserRow(user: User, onDelete: (Int) -> Unit) {
    // val onItemClick = { id: Int -> selectedId = id }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
            .background( if (user.id % 2 == 0)
                Color.Green
            else
                Color.Transparent
            )
            .clickable{
                // onItemClick.invoke(user.id)
            }
    ) {
        Text(
            text = user.id.toString(),
            modifier = Modifier.weight(0.1f),
            fontSize = 24.sp
        )
        Text(
            text = user.name,
            modifier = Modifier.weight(0.2f),
            fontSize = 24.sp
        )
        Text(
            text = user.age.toString(),
            modifier = Modifier.weight(0.2f),
            fontSize = 24.sp
        )
        Text(
            text = "Delete",
            color = Color(0xFF6650A4),
            fontSize = 24.sp,
            modifier = Modifier
                .weight(0.2f)
                .clickable { onDelete(user.id) }
        )
    }
}

@Composable
fun UserTitleRow() {
    Spacer (modifier = Modifier.padding(8.dp))
    Row(
        modifier = Modifier
            .background(Color.LightGray)
            .fillMaxWidth()
            .padding(8.dp)
        //.clickable()
    ) {
        Text(
            text = "ID",
            color = Color.White,
            modifier = Modifier.weight(0.1f),
            fontSize = 24.sp
        )
        Text(
            text = "Name",
            color = Color.White,
            modifier = Modifier.weight(0.2f),
            fontSize = 24.sp
        )
        Text(
            text = "Age",
            color = Color.White,
            modifier = Modifier.weight(0.2f),
            fontSize = 24.sp
        )
        Spacer(modifier = Modifier.weight(0.2f))
    }
    Spacer (modifier = Modifier.padding(4.dp))
}*/
