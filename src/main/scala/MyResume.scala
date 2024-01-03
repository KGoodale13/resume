import java.time.Month

import resumedata.Resume
import resumedata.Resume._

object MyResume {

  private val contact = ContactInfo(
    name = "Kyle Goodale",
    email = "kgoodale13@gmail.com",
    address = Address(city = "Boston", state = "MA", zip = "02127")
  )

  private val socialLinks = Seq(
    Link("linkedin.com/in/kgoodale13", "https://linkedin.com/in/kgoodale13"),
    Link("GitHub: @KGoodale13", "https://github.com/kgoodale13"),
    Link("KyleGoodale.com", "https://kylegoodale.com")
  )

  private val languages = Seq(
    // Languages
    Skill("Scala", SkillLevel.Expert),
    Skill("Java", SkillLevel.Advanced),
    Skill("Python", SkillLevel.Intermediate),
    Skill("Kotlin", SkillLevel.Intermediate),
    Skill("JavaScript", SkillLevel.Beginner),
    Skill("TypeScript", SkillLevel.Beginner),
  )

  private val technologies = Seq(
    // Technologies
    Skill("Data Streaming", SkillLevel.Expert),
    Skill("Akka Streams", SkillLevel.Expert),
    Skill("Data Platform Development", SkillLevel.Advanced),
    Skill("Kubernetes", SkillLevel.Advanced),
    Skill("SQL", SkillLevel.Advanced),
    Skill("Postgres", SkillLevel.Advanced),
    Skill("Kafka", SkillLevel.Advanced),
    Skill("Functional Programming", SkillLevel.Advanced),
    Skill("ElasticSearch", SkillLevel.Advanced),
    Skill("Amazon Web Services (AWS)", SkillLevel.Intermediate),
  )

  private val skillCategories = Map("Languages" -> languages, "Technologies" -> technologies)

  private val workExperience = Seq(
    WorkExperience(
      jobTitle = "Software Engineer",
      company = LinkOption("Threat Stack", Some("https://threatstack.com")),
      highlights = Seq(
        "Developed highly available microservices for various projects. Leveraging functional programming heavily",
        "Developed and maintained a streaming query language for classifying and filtering millions of events per second",
        "Developed and maintained various high performance streaming applications capable of processing millions of events per second",
        "Developed and maintained a large data platform storing hundreds of terabytes of data",
        "Optimized existing streaming services to cut operating costs by over half",
        "Received many awards for performance",
        "Developed tools for identifying performance bottlenecks and application failures",
      ),
      skillsUsed = Seq(
        "Scala",
        "Akka Streams",
        "Functional Programming",
        "Finch/Finagle (Twitter Stack)",
        "SQL",
        "Postgres",
        "ElasticSearch",
        "Parquet",
        "Hive",
        "Spark",
      ),
      startDate = ResumeDate(Month.JULY, 2019),
      endDate = Some(ResumeDate(Month.OCTOBER, 2021)),
    ),
    WorkExperience(
      jobTitle = "Senior Software Engineer",
      company = LinkOption("F5", Some("https://f5.com")),
      highlights = Seq(
        "Created a new generic query language for executing queries across multiple data stores",
        "Created a platform for containerizing and deploying any machine learning model",
        "Led a complex project rewriting one of the oldest parts of our platform while ensuring no interruption to the existing feature",
      ),
      skillsUsed = Seq(
        "Scala",
        "Python",
        "Akka Streams",
        "MLFlow",
        "Kubernetes",
        "Functional Programming",
        "SQL",
        "Postgres",
        "Spark",
      ),
      startDate = ResumeDate(Month.OCTOBER, 2021),
      endDate = None,
    ),
  )

  private val projectExperience = Seq()

  val resume = Resume(
    aboutMe =
      "Senior Software Engineer specializing in high performance data streaming, distributed computing, and language parsing. Enjoys solving complex problems and learning new technologies. Functional programming enthusiast.",
    contactInfo = contact,
    links = socialLinks,
    education = Education(
      institution = "University of Maine",
      degreeType = "B.S",
      major = "Computer Science",
    ),
    skills = skillCategories,
    workExperience = workExperience,
    projectExperience = projectExperience
  )

}
