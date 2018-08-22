package com.web.link.checker.project.controllerTest;

import com.web.link.checker.facade.ProjectFacade;
import com.web.link.checker.model.Project;
import com.web.link.checker.model.ProjectInsert;
import com.web.link.checker.model.ProjectUpdate;
import com.web.link.checker.repository.ProjectRepository;
import com.web.link.checker.view.ProjectView;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static com.web.link.checker.controller.ProjectBinding.*;
import static com.web.link.checker.controller.ProjectionBinding.PROJECT;
import static com.web.link.checker.controller.ProjectionBinding.PROJECT_PROJECTION_PAGE;
import static org.springframework.http.MediaType.TEXT_PLAIN;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class ProjectControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ProjectFacade projectFacade;

    @Autowired
    private ProjectRepository projectRepository;

    private String projectName;

    @Test
    public void projectsWithPageableViewTest() throws Exception {
        insertTest();
        this.mockMvc.perform(get(BASE_PATH)
                .accept(TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists(PROJECT_PROJECTION_PAGE))
                .andExpect(view().name(ProjectView.LIST_VIEW));
        //.andExpect(content().string(containsString(projectName)));
    }

    @Test
    public void insertTest() throws Exception {
        this.projectName = UUID.randomUUID().toString();
        this.mockMvc.perform(post(BASE_PATH + INSERT_PATH)
                .param("name", projectName)
                .flashAttr(PROJECT, new ProjectInsert()))
                .andExpect(redirectedUrl(BASE_PATH));
    }

    @Test
    public void updateTest() throws Exception {
        insertTest();
        String uuid = getUuidProject(projectName);
        String url = addUuidToUrl(BASE_PATH + UPDATE_PATH, uuid);
        String projectNameNew =  UUID.randomUUID().toString();

        this.mockMvc.perform(post(url)
                .param("name", projectNameNew)
                .flashAttr(PROJECT, new ProjectUpdate()))
                .andExpect(redirectedUrl(BASE_PATH));
    }

    @Test
    public void deleteTest() throws Exception {
        insertTest();
        String uuid = getUuidProject(projectName);
        String url = addUuidToUrl(BASE_PATH + DELETE_PATH, uuid);

        this.mockMvc.perform(delete(url))
                .andExpect(status().isOk());
    }

    private String getUuidProject(String projectName) {
        Iterable<Project> projectsIterable = projectRepository.findAll();
        List<Project> projects = StreamSupport.stream(projectsIterable.spliterator(), false)
                .collect(Collectors.toList());
        Project projectExist = projects.stream().filter(project ->
                project.getName().contains(projectName)).findAny().orElse(null);
        return projectExist.getUuid();
    }

    private String addUuidToUrl(String url, String uuid) {
        return url.replaceAll("\\{uuid}", uuid);
    }
}
