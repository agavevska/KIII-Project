package mk.ukim.finki.emc.roombookingbackend.web.controllers;

import mk.ukim.finki.emc.roombookingbackend.dto.domain.CreateWorkspaceDto;
import mk.ukim.finki.emc.roombookingbackend.dto.domain.DisplayWorkspaceDto;
import mk.ukim.finki.emc.roombookingbackend.service.application.WorkspaceApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/workspaces")
@RestController
public class WorkspaceController {

    private final WorkspaceApplicationService workspaceApplicationService;

    public WorkspaceController(WorkspaceApplicationService workspaceApplicationService) {
        this.workspaceApplicationService = workspaceApplicationService;
    }

    @GetMapping
    public ResponseEntity<List<DisplayWorkspaceDto>> findAll() {
        return ResponseEntity.ok(workspaceApplicationService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisplayWorkspaceDto> findById(@PathVariable Long id) {
        return workspaceApplicationService
                .findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<DisplayWorkspaceDto> save(@RequestBody CreateWorkspaceDto createWorkspaceDto) {
        return ResponseEntity.ok(workspaceApplicationService.save(createWorkspaceDto));
    }

    @PutMapping("/{id}/edit")
    public ResponseEntity<DisplayWorkspaceDto> update(
            @PathVariable Long id,
            @RequestBody CreateWorkspaceDto createWorkspaceDto
    ) {
        return workspaceApplicationService
                .update(id, createWorkspaceDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<DisplayWorkspaceDto> deleteById(@PathVariable Long id) {
        return workspaceApplicationService
                .deleteById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
