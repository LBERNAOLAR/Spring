package com.indizen.cursoSpring.servicio.persistence.group;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.indizen.cursoSpring.servicio.model.group.Group;
import com.indizen.cursoSpring.servicio.model.group.GroupExample;
import com.indizen.cursoSpring.servicio.persistence.PaginationContext;

@Repository("groupDAO")
public class GroupDAOImpl extends SqlMapClientDaoSupport implements GroupDAO {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_group
     *
     * @mbggenerated Fri Apr 27 11:35:15 CEST 2012
     */
    @Autowired
public GroupDAOImpl(SqlMapClient sqlMapClient) {
        setSqlMapClient(sqlMapClient);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_group
     *
     * @mbggenerated Fri Apr 27 11:35:15 CEST 2012
     */
    public int countByExample(GroupExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("t_group.countByExample", example);
        return count.intValue();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_group
     *
     * @mbggenerated Fri Apr 27 11:35:15 CEST 2012
     */
    public int deleteByExample(GroupExample example) {
        int rows = getSqlMapClientTemplate().delete("t_group.deleteByExample", example);
        return rows;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_group
     *
     * @mbggenerated Fri Apr 27 11:35:15 CEST 2012
     */
    public int deleteByPrimaryKey(Integer id) {
        Group _key = new Group();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("t_group.deleteByPrimaryKey", _key);
        return rows;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_group
     *
     * @mbggenerated Fri Apr 27 11:35:15 CEST 2012
     */
    public Integer insert(Group record) {
        Object newKey = getSqlMapClientTemplate().insert("t_group.insert", record);
        return (Integer) newKey;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_group
     *
     * @mbggenerated Fri Apr 27 11:35:15 CEST 2012
     */
    public Integer insertSelective(Group record) {
        Object newKey = getSqlMapClientTemplate().insert("t_group.insertSelective", record);
        return (Integer) newKey;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_group
     *
     * @mbggenerated Fri Apr 27 11:35:15 CEST 2012
     */
    public List selectByExample(GroupExample example) {
        List list = getSqlMapClientTemplate().queryForList("t_group.selectByExample", example);
        return list;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_group
     *
     * @mbggenerated Fri Apr 27 11:35:15 CEST 2012
     */
    public Group selectByPrimaryKey(Integer id) {
        Group _key = new Group();
        _key.setId(id);
        Group record = (Group) getSqlMapClientTemplate().queryForObject("t_group.selectByPrimaryKey", _key);
        return record;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_group
     *
     * @mbggenerated Fri Apr 27 11:35:15 CEST 2012
     */
    public int updateByExampleSelective(Group record, GroupExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("t_group.updateByExampleSelective", parms);
        return rows;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_group
     *
     * @mbggenerated Fri Apr 27 11:35:15 CEST 2012
     */
    public int updateByExample(Group record, GroupExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("t_group.updateByExample", parms);
        return rows;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_group
     *
     * @mbggenerated Fri Apr 27 11:35:15 CEST 2012
     */
    public int updateByPrimaryKeySelective(Group record) {
        int rows = getSqlMapClientTemplate().update("t_group.updateByPrimaryKeySelective", record);
        return rows;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_group
     *
     * @mbggenerated Fri Apr 27 11:35:15 CEST 2012
     */
    public int updateByPrimaryKey(Group record) {
        int rows = getSqlMapClientTemplate().update("t_group.updateByPrimaryKey", record);
        return rows;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_group
     *
     * @mbggenerated Fri Apr 27 11:35:15 CEST 2012
     */
    protected static class UpdateByExampleParms extends GroupExample {
        private Object record;

        public UpdateByExampleParms(Object record, GroupExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
	/**
    * Selecciona un conjunto de resultados basados en un ejemplo y 
    * los pagina.
    * @param example Objeto de ejemplo para la query
    * @param paginationContext Objeto utilizado para controlar la paginación
    * @return lista de elementos pertenecientes a la página correspondiente
    */
    public List<Group> selectByExamplePaginated(GroupExample example, PaginationContext paginationContext) {
    	assert paginationContext.getSkipResults() >= 0;
		assert paginationContext.getMaxResults() >= 0;
		
		final List<Group> result = new ArrayList<Group>();
		
		//Obtiene y actualiza el número total de resultados del ejemplo
		paginationContext.updateTotalCount((Integer) countByExample(example));
	
		//iBatis hace la paginación física de los resultados usando un cursos
		//si está disponible la función ResultSet.absolute(position);
		final List<Group> queryForList = getSqlMapClientTemplate().queryForList("t_group.selectByExample", 
				example,paginationContext.getSkipResults(),
				paginationContext.getMaxResults());	
		result.addAll(queryForList);
		return Collections.unmodifiableList(result);     
    }	
	
	/**
	 * 
	 * Borra todos los datos de la tabla
	 * 
	 */
	public void deleteAllData(){
		getSqlMapClientTemplate().delete("t_group.trucate_table");
	}
   
}