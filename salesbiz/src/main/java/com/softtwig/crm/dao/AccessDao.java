package com.softtwig.crm.dao;

import java.util.List;

import com.softtwig.crm.bo.AccessBo;
import com.softtwig.crm.vo.AccessVo;

public interface AccessDao {

	AccessVo AccessCreateValue(AccessVo acccessVo);

	List<AccessBo> viewAccessDao();

	AccessVo updateDao(AccessVo accessVo);

	AccessVo deleteAccess(AccessVo accessvo);

	List<AccessVo> searchAccessValue(AccessVo accessvo);

}
