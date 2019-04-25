package io.prometheus.remote;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.xerial.snappy.Snappy;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;

import prometheus.Remote.WriteRequest;
import prometheus.Types.Label;
import prometheus.Types.Sample;
import prometheus.Types.TimeSeries;

@RestController
public class RemoteController {

	static Logger logger = LoggerFactory.getLogger(RemoteController.class);

	@RequestMapping(method = RequestMethod.POST, value = "/write")
	public void write(@RequestBody byte[] byteArray) throws IOException {

		WriteRequest wr = WriteRequest.parseFrom(Snappy.uncompress(byteArray));

		logger.info(JsonFormat.printer().print(wr));

		/*
		List<TimeSeries> tsl = wr.getTimeseriesList();

		for (TimeSeries ts : tsl) {
			Map<String, String> lm = ts.getLabelsList().stream()
					.collect(Collectors.toMap(Label::getName, Label::getValue));
			List<Sample> ls = ts.getSamplesList();

			for (Sample s : ls) {

				
				String timestamp = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX")
						.format(new Date(s.getTimestamp()));
				String name = lm.get("__name__");
				String value = String.valueOf(s.getValue());

				logger.info("Sample: timestamp=" + timestamp + ", name=" + name + ", value=" + value + ", labels=" + mapAsString(lm));
				
			}
		}
		*/
	}
	
	/*
	private String mapAsString(Map<String, String> map) {
	    String mapAsString = map.keySet().stream()
	      .map(key -> key + "=" + map.get(key))
	      .collect(Collectors.joining(", ", "{", "}"));
	    return mapAsString;
	}
	*/

}