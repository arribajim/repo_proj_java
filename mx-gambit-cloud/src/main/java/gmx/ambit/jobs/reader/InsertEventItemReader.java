package gmx.ambit.jobs.reader;

import java.io.File;

import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.context.annotation.Bean;

public class InsertEventItemReader implements ItemReader<File> {

	@Bean("customItemReader")
	@JobScope
	@Override
	public File read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		// TODO Auto-generated method stub
		
		return null;
	}

}
