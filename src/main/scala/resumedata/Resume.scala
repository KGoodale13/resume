package resumedata

import java.time.Month

import resumedata.Resume._

case class Resume(
    aboutMe: String,
    contactInfo: ContactInfo,
    links: Seq[Link],
    education: Education,
    skills: Map[String, Seq[Skill]],
    workExperience: Seq[WorkExperience],
    projectExperience: Seq[ProjectExperience])

object Resume {

  // General info
  case class Address(city: String, state: String, zip: String)
  case class ContactInfo(name: String, email: String, address: Address)

  case class Education(institution: String, degreeType: String, major: String)

  case class Link(name: String, href: String)
  case class LinkOption(name: String, href: Option[String])

  // Skill stuff
  sealed trait SkillLevel {
    val rank: Int = 0 // Used for sorting the skill levels. higher = more advanced
  }
  object SkillLevel {

    case object Beginner extends SkillLevel {
      override val rank: Int = 1
      override def toString: String = "Beginner"
    }

    case object Intermediate extends SkillLevel {
      override val rank: Int = 2
      override def toString: String = "Intermediate"
    }

    case object Advanced extends SkillLevel {
      override val rank: Int = 3
      override def toString: String = "Advanced"
    }

    case object Expert extends SkillLevel {
      override val rank: Int = 4
      override def toString: String = "Expert"
    }

  }

  case class Skill(name: String, level: SkillLevel)

  // Work experience
  case class ResumeDate(month: Month, year: Int) {
    import java.text.DateFormatSymbols
    val monthName = new DateFormatSymbols().getMonths()(month.getValue - 1)

    // decimal value used for ordering
    val orderingNumber: BigDecimal =
      BigDecimal(year + (month.getValue / 12))
  }
  case class WorkExperience(
      jobTitle: String,
      company: LinkOption,
      highlights: Seq[String],
      skillsUsed: Seq[String],
      startDate: ResumeDate,
      endDate: Option[ResumeDate])

  // Projects
  case class ProjectExperience(
      title: LinkOption,
      role: String,
      summary: String,
      highlights: Seq[String],
      skills: Seq[String])

}
