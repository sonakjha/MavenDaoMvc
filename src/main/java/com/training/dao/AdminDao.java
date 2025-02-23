package com.training.dao.util;

import java.util.List;

import com.training.model.Admin;

public interface AdminDao {
	

	 long addAdmin(Admin tech);
	long updateAdmin(Admin tech);
	Admin getAdminById(long id);
	List<Admin> getAllAdmin();
	long deleteAdminById(long id);
   public String[] getAllColumns();
long addTeacher(Admin tech);


}
