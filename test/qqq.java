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
	}

}
