package ci.ipmd.ecole.entites;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Role {
	    @Id
	    private String id;
	    
        private String name;

		public Role() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Role(String name) {
			super();
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return "Role [id=" + id + ", name=" + name + "]";
		}
        		
}
