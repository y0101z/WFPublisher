package com.wf.publisher.controller;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.wf.publisher.exception.WFException;
import com.wf.publisher.model.Click;
import com.wf.publisher.model.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "WFControllerAPI", produces = MediaType.APPLICATION_JSON_VALUE)
public class WFController
{
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private KafkaTemplate<String, Object> template;
	
	@Value("${kafka.topic.users}")
	private String topicUsers;
	@Value("${kafka.topic.clicks}")
	private String topicClicks;
	
	@RequestMapping(value = "/publish/click", method = RequestMethod.POST, produces = "application/json")
	@ApiOperation(value = "Publish Click")
	public ResponseEntity<Click> publishClick(@RequestBody Click click) throws WFException
	{	
		if(click == null) // todo: object validation should be here
			throw new WFException("Invalid user.");
		
		click.setId(UUID.randomUUID());
		template.send(topicClicks, click);
		log.debug("Published Click {}", click.toString()); 
		
		return new ResponseEntity<Click>(click, HttpStatus.OK);		
	}
	
	@RequestMapping(value = "/publish/user", method = RequestMethod.POST, produces = "application/json")
	@ApiOperation(value = "Publish User")
	public ResponseEntity<User> publishUser(@RequestBody User user) throws WFException
	{	
		if(user == null) // todo: object validation should be here
			throw new WFException("Invalid user.");
		
		user.setId(UUID.randomUUID());
		template.send(topicUsers, user);
		log.debug("Published User {}", user.toString()); 
		
		return new ResponseEntity<User>(user, HttpStatus.OK);		
	}
}
