package dao;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import entity.Prize;
import util.BaseDao;

public class PrizeDao extends BaseDao{
	//查询排序
		public List<Prize> selectAllpaixu() {
			String sql ="SELECT * FROM prize ORDER BY gold_medal_count DESC ,silver_medal_count DESC,brass_medal_count DESC";
			try {
				// 2、获取连接对象
				conn = getConn();
				// 3、预编译SQL语句
				stmt = conn.prepareStatement(sql);
				// 5、执行SQL语句，返回到结果集中
				rs = stmt.executeQuery();
				// 6、将结果集中的数据转存到集合中
				List<Prize> list = null;
				if (rs != null) {
					list = new ArrayList<Prize>();
					while (rs.next()) {
						// 调用rs.getXXX("列名") 获取游标指向行的数据
						Integer prize_id = rs.getInt("prize_id");
						String country = rs.getString("country");
						Integer gold_medal_count = rs.getInt("gold_medal_count");
						Integer silver_medal_count = rs.getInt("silver_medal_count");
						Integer brass_medal_count = rs.getInt("brass_medal_count");
						// 将获取到的数据，封装到实体类对象中
						// 一行记录--->一个对象
						Prize obj=new Prize(prize_id, country, gold_medal_count, silver_medal_count, brass_medal_count);
						// 将对象添加到集合中
						list.add(obj);
					}
				}
				return list;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;

		}
		public List<Prize> selectAll(String name) {
			String sql ="SELECT * FROM prize WHERE country=?";
			try {
				// 2、获取连接对象
				conn = getConn();
				// 3、预编译SQL语句
				stmt = conn.prepareStatement(sql);
				// 4、填充参数
				stmt.setObject(1, name);
				// 5、执行SQL语句，返回到结果集中
				rs = stmt.executeQuery();
				// 6、将结果集中的数据转存到集合中
				List<Prize> list = null;
				if (rs != null) {
					list = new ArrayList<Prize>();
					while (rs.next()) {
						// 调用rs.getXXX("列名") 获取游标指向行的数据
						Integer prize_id = rs.getInt("prize_id");
						String country = rs.getString("country");
						Integer gold_medal_count = rs.getInt("gold_medal_count");
						Integer silver_medal_count = rs.getInt("silver_medal_count");
						Integer brass_medal_count = rs.getInt("brass_medal_count");
						// 将获取到的数据，封装到实体类对象中
						// 一行记录--->一个对象
						Prize obj=new Prize(prize_id, country, gold_medal_count, silver_medal_count, brass_medal_count);
						// 将对象添加到集合中
						list.add(obj);
					}
				}
				return list;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;

		}

		// 、doUpdate(实体类):int 修改金牌数量
		public Integer doupdateJIN(Prize obj) {
			// 1、准备修改sql语句
			String sql = "update prize set gold_medal_count=? where country=?";

			try {
				// 2、获取连接对象
				conn = super.getConn();
				// 3、预编译SQL语句
				stmt = conn.prepareStatement(sql);
				// 4、填充参数
				stmt.setObject(1, obj.getGold_medal_count());
				stmt.setObject(2, obj.getCountry());
				// 5、执行SQL语句
				return stmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				super.closeAll();
			}
			return -1;// 最后返回-1，表示代码运行到这里，新增失败
		}
		
		// 、doUpdate(实体类):int 修改银牌数量
			public Integer doupdateYIN(Prize obj) {
				// 1、准备修改sql语句
				String sql = "update prize set silver_medal_count=? where country=?";

				try {
					// 2、获取连接对象
					conn = super.getConn();
					// 3、预编译SQL语句
					stmt = conn.prepareStatement(sql);
					// 4、填充参数
					stmt.setObject(1, obj.getSilver_medal_count());
					stmt.setObject(2, obj.getCountry());
					// 5、执行SQL语句
					return stmt.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					super.closeAll();
				}
				return -1;// 最后返回-1，表示代码运行到这里，新增失败
			}
			// 4、doUpdate(实体类):int 修改铜牌数量
					public Integer doupdateTONG(Prize obj) {
						// 1、准备修改sql语句
						String sql = "update prize set brass_medal_count=? where country=?";

						try {
							// 2、获取连接对象
							conn = super.getConn();
							// 3、预编译SQL语句
							stmt = conn.prepareStatement(sql);
							// 4、填充参数
							stmt.setObject(1, obj.getBrass_medal_count());
							stmt.setObject(2, obj.getCountry());
							// 5、执行SQL语句
							return stmt.executeUpdate();
						} catch (SQLException e) {
							e.printStackTrace();
						} finally {
							super.closeAll();
						}
						return -1;// 最后返回-1，表示代码运行到这里，新增失败
					}
	}
