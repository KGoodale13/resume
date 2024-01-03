import io.github.cloudify.scala.spdf._
import java.io._
import java.net._
import java.nio.file.{Files, Paths}

import templates.standard.Standard

object Main extends App {

  val pdf = Pdf(new PdfConfig {
    orientation := Portrait
    pageSize := "Letter"
    marginTop := "0.5in"
    marginBottom := "0.5in"
    marginLeft := "0.5in"
    marginRight := "0.5in"
  })

  val resume = MyResume.resume

  // Build the resume with our standard template
  val htmlResume = Standard.create(resume)

  // convert it to a pdf
  val outputStream = new ByteArrayOutputStream()
  pdf.run(htmlResume, outputStream)

  // save it
  val filename: String = "resume.pdf"

  try Files.write(Paths.get(filename), outputStream.toByteArray)
  finally outputStream.close()

}
