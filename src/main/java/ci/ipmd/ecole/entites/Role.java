package ci.ipmd.ecole.entites;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "roles")
public class Role {
	    @Id
	    private String id;
	    private Set<Integer> code = new HashSet<>();
	    
        private ERole name;

		public Role() {
			super();
		}

		public Role(ERole name) {
			super();
			this.name = name;
		}

		
		public Role(Set<Integer> code) {
			super();
			this.code = code;
		}

		public Role(Set<Integer> code, ERole name) {
			super();
			this.code = code;
			this.name = name;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}
        
		public ERole getName() {
			return name;
		}

		public void setName(ERole name) {
			this.name = name;
		}

		public Set<Integer> getCode() {
			return code;
		}

		public void setCode(Set<Integer> code) {
			this.code = code;
		}

		@Override
		public String toString() {
			return "Role [id=" + id + ", code=" + code + ", name=" + name + "]";
		}

		
}
