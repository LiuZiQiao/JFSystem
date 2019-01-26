package com.lxk.JFSystem.utils;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;

import com.lxk.JFSystem.domain.Vedio;

public class Test {
public static void main(String[] args) {
		try {
			
			QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
			String sql = "select  vedioId from t_vedio where vedioId =?";
//			Vedio vedio = queryRunner.query(sql, new BeanHandler<Vedio>(Vedio.class));
//			System.out.println(vedio);
//			Object[] pargam = {1,2,3};
			String pargam = "2";
			Map<String, Object> vedio = queryRunner.query(sql, new MapHandler(),pargam);
			System.out.println(vedio);
//			for (int i = 0; i < vedio.size(); i++) {
//				System.out.println(vedio.get(i).getVedioId()+vedio.get(i).getVedioName());
//			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
}

}


