package eu.tutorials.myrecipeapp
// the sealed modifier is used to restrict the inheritance hierarchy for a class or a class
// hierarchy. When a class is marked as sealed, it means that the class can only be subclassed
// from within the same file where it is declared. This means that all subclasses of a sealed
// class must be declared within the same Kotlin file where the sealed class itself is declared.
sealed class Screen(val route : String) {
    object recipeScreen : Screen("recipeScreen")
    object detailScreen : Screen("detailScreen")

}