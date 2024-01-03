package util

object StringUtils {

  private val punctuationCharacters = Seq('.', '!', '?', ';')

  // Punctuates the phrase if it is not already punctuated
  def punctuateIfNot(string: String) =
    string.trim match {
      case s if punctuationCharacters.contains(s.last) => s
      case s                                           => s + "."
    }

}
