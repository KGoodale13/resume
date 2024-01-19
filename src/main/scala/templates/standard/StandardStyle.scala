package templates.standard

import scalacss.DevDefaults._

object StandardStyle extends StyleSheet.Inline {
  import dsl._

  private val georgiaFont = fontFace("georgia")(_.src("local(Georgia)"))

  private val helveticaFont = fontFace("helvetica")(_.src("local(Helvetica)"))

  val name = style(fontSize(32 pt), textAlign.center, fontFamily(georgiaFont))

  val contactInfo =
    style(fontSize(10 pt), textAlign.center, fontFamily(georgiaFont))

  val heading = style(
    fontSize(11 pt),
    color(Color("#000000")),
    marginBottom(10 px),
    textAlign.left,
    fontFamily(georgiaFont),
    textTransform.uppercase,
    fontWeight._800
  )

  val subheading =
    style(fontSize(11 pt), overflow.hidden, fontFamily(georgiaFont))

  val subheadingLeft = style(float.left, overflow.hidden, fontWeight._700)
  val subheadingRight = style(float.right)

  val body = style(fontSize(11 pt), textAlign.left, fontFamily(helveticaFont), lineHeight(1.2))

  val list = style(marginTop(0 px))

}
