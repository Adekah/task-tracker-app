import { Component, OnInit, TemplateRef, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { BsModalRef, BsModalService } from 'ngx-bootstrap';
import { Page } from 'src/app/common/page';
import { ProjectService } from 'src/app/services/shared/project.service';
import { ConfirmationComponent } from 'src/app/shared/confirmation/confirmation.component';

@Component({
  selector: 'app-project',
  templateUrl: './project.component.html',
  styleUrls: ['./project.component.scss']
})
export class ProjectComponent implements OnInit {

  modalRef:BsModalRef;
  projectForm: FormGroup;
  @ViewChild('tplProjectDeleteCell') tplProjectDeleteCell: TemplateRef<any>;

  page = new Page();
  cols = [];
  rows = [];


  constructor(private projectService: ProjectService,private modalService:BsModalService,  private formBuilder: FormBuilder) { }

  ngOnInit() {

    this.cols = [
      {prop: 'id', name: 'Project No'},
      {prop: 'projectName', name: 'Project Name', sortable: false},
      {prop: 'projectCode', name: 'Project Code', sortable: false},
      {prop: 'id', name: 'Actions', cellTemplate: this.tplProjectDeleteCell, sortable: false}];

    this.setPage({ offset: 0 })


    this.projectForm = this.formBuilder.group({
      'projectCode': [null, [Validators.required, Validators.minLength(2), Validators.maxLength(10)]],
      'projectName': [null, [Validators.required, Validators.minLength(4)]],
      
    });
  }

  openModal(template: TemplateRef<any>) {
    this.modalRef = this.modalService.show(template);
  }

  get f() {
    return this.projectForm.controls
  }

  saveProject() {
    if (!this.projectForm.valid)
      return;
    this.projectService.createProject(this.projectForm.value).subscribe(
      response => {
        this.setPage({offset:0})
        this.closeAndResetModal();
      }
    )

  }
  closeAndResetModal() {
    this.projectForm.reset();
    this.modalRef.hide();
  }

  setPage(pageInfo) {
    this.page.page = pageInfo.offset;
    this.projectService.getAll(this.page).subscribe(pagedData => {
      this.page.size = pagedData.size;
      this.page.page = pagedData.page;
      this.page.totalElements = pagedData.totalElements;
      this.rows = pagedData.content;
    });
  }

  showProjectDeleteConfirmation(value) {
    const modal = this.modalService.show(ConfirmationComponent);
    (<ConfirmationComponent>modal.content).showConfirmation(
      'Delete Confirmation', 'Are you sure for delete Project'
    );

    (<ConfirmationComponent>modal.content).onClose.subscribe(result => {
      if (result === true) {
        this.projectService.delete(value).subscribe(
          response => {
            if (response === true) {
              this.setPage({offset: 0})
            }
          }
        );
      } else if (result === false) {
      }
    })
  }

}
