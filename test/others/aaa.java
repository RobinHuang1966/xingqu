import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class qqq{
	public static void main(String[] args) {
		Configuration conf=new AnnotationConfiguration();
		conf.configure("/hibernate.cfg.xml");
		SchemaExport dbExport=new SchemaExport(conf);
		dbExport.create(true, true);
		System.out.println("HelloWorld");
		System.out.println("This is in the IdeaProjects!");
		System.out.println("Merge in github,testing pull and push");
		System.out.println("This is in the IdeaProjects 2.");
		System.out.println("This is in the github2");
		System.out.println("This is in the github 3.");
		System.out.println("This is in the IdeaProjects 4.");
		System.out.println("This is in the github 4.");
		System.out.println("This is in the github 5.");
		System.out.println("This is in the IdeaProjects 5.");
		System.out.println("This is in the test/others file 1");
	}

}
