package templates

import resumedata.Resume

import scala.xml.Elem

trait ResumeTemplate {
  def create(resume: Resume): Elem
}
