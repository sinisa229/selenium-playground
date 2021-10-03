package com.selenium.playground;

import org.testcontainers.containers.DockerComposeContainer;

import java.io.File;

public class DockerSeleniumGridProvider {

    public DockerComposeContainer getGrid() {
        //TODO add conditional logic to switch between regular grid and grid with video capabilities
        return getVideoEnvironment();
    }

    private DockerComposeContainer getVideoEnvironment() {
        return new DockerComposeContainer(new File("docker-compose-video.yml"))
                .withServices("chrome_video")
                .withLocalCompose(true);
    }

    private DockerComposeContainer getDockerGrid() {
        return new DockerComposeContainer(new File("docker-compose.yml"))
                .withExposedService("selenium-hub", 4444)
                .withExposedService("chrome", 5555)
                .withExposedService("firefox", 5555)
                .withLocalCompose(false);
    }
}
