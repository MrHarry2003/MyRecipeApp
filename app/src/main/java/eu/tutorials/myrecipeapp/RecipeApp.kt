package eu.tutorials.myrecipeapp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun RecipeApp(navController : NavHostController){

    val recipeViewModel : MainViewModel = viewModel()
    val viewState by recipeViewModel.categoriesState
    
    NavHost(navController = navController, startDestination = Screen.recipeScreen.route ){
        composable(route=Screen.recipeScreen.route){
            RecipeScreen(viewstate = viewState , navigateToDetail = {
                //This part is responsible for passing data from the current screen to
                //the detail screen and it utilizes the savedStateHandle which is a component
                //of the compose navigation framework
                navController.currentBackStackEntry?.savedStateHandle?.set("cat",it)
                navController.navigate(Screen.detailScreen.route)

            })
        }

        composable(route=Screen.detailScreen.route){
            //using previous backStack entries which is saved and retrieving the category data
        val category = navController.previousBackStackEntry?.savedStateHandle?.
            get<Category>("cat")?:Category("","","","")
            CategoryDetailScreen(category = category)
        }

    }

}