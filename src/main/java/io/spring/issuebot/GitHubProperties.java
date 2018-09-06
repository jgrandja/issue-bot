/*
 * Copyright 2015-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.spring.issuebot;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

/**
 * {@link ConfigurationProperties} for connecting to GitHub.
 *
 * @author Andy Wilkinson
 */
@ConfigurationProperties(prefix = "issuebot.github")
@Getter
@Setter
public class GitHubProperties {

	@NestedConfigurationProperty
	private Repository repository = new Repository();

	@NestedConfigurationProperty
	private Credentials credentials = new Credentials();

	/**
	 * Configuration for a GitHub repository.
	 */
	@Getter
	@Setter
	public static class Repository {

		/**
		 * The name of the organization that owns the repository.
		 */
		private String organization;

		/**
		 * The name of the repository.
		 */
		private String name;

		/**
		 * The names of the repository's collaborators.
		 */
		private List<String> collaborators;

	}

	/**
	 * Configuration for the credentials used to authenticate with GitHub.
	 */
	@Getter
	@Setter
	public static class Credentials {

		/**
		 * The username used for authentication with GitHub.
		 */
		private String username;

		/**
		 * The password used for authentication with GitHub.
		 */
		private String password;

	}

}
