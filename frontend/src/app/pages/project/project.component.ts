import { Component, OnInit } from '@angular/core';
import { Page } from 'src/app/common/page';
import { ProjectService } from 'src/app/services/shared/project.service';

@Component({
  selector: 'app-project',
  templateUrl: './project.component.html',
  styleUrls: ['./project.component.scss']
})
export class ProjectComponent implements OnInit {
  page = new Page();
  cols = [
    { prop: 'id', name: 'No' },
    { prop: 'projectName', name: 'Project Name', sortable: false },
    { prop: 'projectCode', name: 'Project Code', sortable: false }];
  rows = [];


  constructor(private projectService: ProjectService) { }

  ngOnInit() {
    this.setPage({ offset: 0 })

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

}
