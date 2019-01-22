package com.wf.publisher.model;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Click
{
	private UUID id;
	private UUID userId;
	private UUID applicationId;
}
