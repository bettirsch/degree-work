package repository;

import java.util.List;

import model.Form;
import repository.util.BaseRepository;
import utils.enums.FormType;

public interface FormRepository extends BaseRepository<Form>{

	List<Form> getAllFormByType(FormType type);

	Integer getLastSerialNumberByCurrentYear();

	Integer countByFormNr(String formNr);
}
