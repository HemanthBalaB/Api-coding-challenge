import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { ShowTasks } from '../show-tasks/show-tasks';
import { GetTaskById } from '../get-task-by-id/get-task-by-id';
import { CreateTask } from '../create-task/create-task';
import { UpdateTask } from '../update-task/update-task';
import { DeleteTask } from '../delete-task/delete-task';

@Component({
  selector: 'app-main-menu',
  standalone: true,
  imports: [CommonModule, FormsModule, RouterModule, ShowTasks, GetTaskById, CreateTask, UpdateTask, DeleteTask],
  templateUrl: './main-menu.html',
  styleUrls: ['./main-menu.css']
})
export class MainMenu {
  selectedOption: string = '';

  menuOptions = [
    { value: 'show', label: 'Show All Tasks', icon: '📋' },
    { value: 'get', label: 'Get Task By ID', icon: '🔍' },
    { value: 'create', label: 'Create Task', icon: '➕' },
    { value: 'update', label: 'Update Task', icon: '✏️' },
    { value: 'delete', label: 'Delete Task', icon: '🗑️' }
  ];

  selectOption(option: string) {
    this.selectedOption = option;
  }
}
