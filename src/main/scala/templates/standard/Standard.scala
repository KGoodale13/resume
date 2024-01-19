package templates.standard

import resumedata.Resume
import resumedata.Resume.{Education, Link, LinkOption, ProjectExperience, ResumeDate, WorkExperience}
import templates.ResumeTemplate

import scala.xml.{Elem, Text}
import scalacss.DevDefaults._
import util.StringUtils

import java.time.Month

object Standard extends ResumeTemplate {

  private def heading(implicit resume: Resume) =
    <div>
      <div class={StandardStyle.name.htmlClass}>{resume.contactInfo.name}</div>
      <div class={StandardStyle.contactInfo.htmlClass}>
        {resume.contactInfo.email} | {resume.contactInfo.address.city}, {resume.contactInfo.address.state} {resume.contactInfo.address.zip}
      </div>
      <div class={StandardStyle.contactInfo.htmlClass}>
        {resume.links.flatMap(l => List(printLink(l), Text(" | "))).dropRight(1)}
      </div>
    </div>

  private def profile(implicit resume: Resume) =
    <div>
      <div class={StandardStyle.heading.htmlClass}>Summary</div>
      {resume.aboutMe}
    </div>

  private def printLink(link: Link) = <a href={link.href}>{link.name}</a>

  private def printLinkOption(linkOpt: LinkOption) =
    linkOpt match {
      case LinkOption(name, Some(link)) => <a href={link}>{name}</a>
      case LinkOption(name, None)       => <span>{name}</span>
    }

  private def printDate(workExperienceDate: ResumeDate) =
    <span>{workExperienceDate.monthName} {workExperienceDate.year}</span>

  private def printDateOpt(workExperienceDateOpt: Option[ResumeDate]) =
    workExperienceDateOpt match {
      case Some(workExperienceDate) => printDate(workExperienceDate)
      case None                     => <span>Present</span>
    }

  private def printEmploymentEntry(workExperience: WorkExperience) =
    <div>
      <div class={StandardStyle.subheading.htmlClass}>
        <div class={StandardStyle.subheadingLeft.htmlClass}>
          {workExperience.jobTitle}, {printLinkOption(workExperience.company)}
        </div>
        <div class={StandardStyle.subheadingRight.htmlClass}>
          {printDate(workExperience.startDate)} - {printDateOpt(workExperience.endDate)}
        </div>
      </div>
      <div>
        <ul class={StandardStyle.list.htmlClass}>
          {workExperience.highlights.map(h => StringUtils.punctuateIfNot(h.capitalize)).map(highlight => <li>{highlight}</li>)}
          <li>Skills Used: {workExperience.skillsUsed.map(_.capitalize).mkString(", ")}</li>
        </ul>
      </div>
    </div>

  private def experience(implicit resume: Resume) =
    <div>
      <div class={StandardStyle.heading.htmlClass}>Experience</div>
      {resume.workExperience.sortBy(_.endDate.fold(BigDecimal(9999))(_.orderingNumber)).reverse.map(printEmploymentEntry)}
    </div>

  private def skills(implicit resume: Resume) =
    <div>
      <div class={StandardStyle.heading.htmlClass}>Skills</div>
      {resume.skills.map {
        case (category, skills) =>
        <div>
          <b>{category}:</b>
          <ul class={StandardStyle.list.htmlClass}>
            {skills.sortBy(_.level.rank)(Ordering.Int.reverse).flatMap(s => List(<li>{s.name} <i>({s.level})</i></li>))}
          </ul>
        </div>
        <br/>
      }}
    </div>

  private def printEducation(education: Education) =
    <div>
      <div class={StandardStyle.subheading.htmlClass}>
        <div class={StandardStyle.subheadingLeft.htmlClass}>
          {education.degreeType}, {education.major}
        </div>
      </div>
      {education.institution}
    </div>

  private def educationSection(implicit resume: Resume) =
    <div>
      <div class={StandardStyle.heading.htmlClass}>Education</div>
      {printEducation(resume.education)}
    </div>

  def create(resume: Resume): Elem = {
    implicit val r: Resume = resume

    <html>
      <head>
        <style>
          {StandardStyle.render}
        </style>
      </head>
      <body class={StandardStyle.body.htmlClass}>
        {heading}
        <hr/>
        {profile}
        <hr/>
        {experience}
        <hr/>
        {skills}
        <hr/>
        {educationSection}
      </body>
    </html>
  }

}
