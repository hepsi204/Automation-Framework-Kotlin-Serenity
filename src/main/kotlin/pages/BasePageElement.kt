package pages

class BasePageElement(
    var desktopLocator :  String,
    var iosLocator : String? = desktopLocator,
    var androidLocator : String? = desktopLocator,
    val page: BasePageObject
) {



}