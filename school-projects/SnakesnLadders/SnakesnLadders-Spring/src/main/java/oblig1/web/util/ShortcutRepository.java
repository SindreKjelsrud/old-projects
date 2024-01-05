package oblig1.web.util;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ShortcutRepository extends JpaRepository<Shortcut, Integer> {

	Shortcut findByFrom1(Integer from1);
	
}
