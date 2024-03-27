package demo;

import java.util.List;
import java.util.Scanner;

import dao.PrizeDao;
import entity.Prize;

public class PrizeDemo {
	// 实例化扫描仪
		static Scanner in = new Scanner(System.in);
		PrizeDao dao = new PrizeDao();

		public static void main(String[] args) {
			PrizeDemo demo = new PrizeDemo();
			System.out.println("1、录入比赛项目获奖国家");
			System.out.println("2、奖牌排行榜");
			System.out.println("请选择：");

			Integer xuan = in.nextInt();
			if (xuan == 1) {
				demo.Luru();
			} else if (xuan == 2) {
				demo.paihang();
			} else {
				System.err.println("请按照要求选：");
				System.out.println("已退出");
				return;
			}

		}

		// 给奖牌录入
		public void Luru() {
			System.out.println("**********奖牌录入**********");
			System.out.println("本次比赛项目获奖国家分别是：");
			System.out.println("金牌获奖者：");

			String jname = in.next();
			//调用查询所有的方法
			List<Prize> list = dao.selectAll(jname);
			boolean jinpai = false;
			for (Prize p : list) {
				if (jname.equals(p.getCountry())) {
					Integer jin = p.getGold_medal_count() + 1;

					Prize pr = new Prize();
					pr.setGold_medal_count(jin);
					pr.setCountry(jname);

					Integer s = dao.doupdateJIN(pr);
					if (s > 0) {
						System.out.println("金牌录入成功");
					} else {
						System.out.println("录入失败!");
					}
					jinpai=true;
				}
				
			}
			//当它找不到国家名时
			if (!jinpai) {
			    System.out.println("未找到该国家信息！");
			    return;
			}


			System.out.println("银牌获奖者：");
			String yname = in.next();
			List<Prize> list1 = dao.selectAll(yname);

			boolean yinpai = false;
			for (Prize p : list1) {
				if (yname.equals(p.getCountry())) {
					Integer yin = p.getSilver_medal_count() + 1;

					Prize pyin = new Prize();
					pyin.setGold_medal_count(yin);
					pyin.setCountry(yname);

					Integer s = dao.doupdateJIN(pyin);
					if (s > 0) {
						System.out.println("银牌录入成功");
					} else {
						System.out.println("录入失败!");
					}

					yinpai=true;
				} 
				
			}
			if (!yinpai) {
			    System.out.println("未找到该国家信息！");
			    return;
			}

			System.out.println("铜牌获奖者：");
			String tname = in.next();
			List<Prize> list2 = dao.selectAll(tname);

			boolean tongpai = false;
			for (Prize p : list2) {
				if (tname.equals(p.getCountry())) {
					Integer tong = p.getBrass_medal_count() + 1;

					Prize ptong = new Prize();
					ptong.setGold_medal_count(tong);
					ptong.setCountry(tname);

					Integer s = dao.doupdateJIN(ptong);
					if (s > 0) {
						System.out.println("铜牌录入成功");
					} else {
						System.out.println("录入失败!");
					}

					tongpai=true;
				} 
			}
			if (!tongpai) {
			    System.out.println("未找到该国家信息！");
			    return;
			}
		}

		// 显示奖牌排行榜
		public void paihang() {
			System.out.println("**********奖牌排行**********");
			List<Prize> list = dao.selectAllpaixu();

			System.out.println("排名\t国家\t金牌\t银牌\t铜牌\t总计");
			Integer i=1;
			for (Prize p : list) {
				//求奖牌总数
				Integer sum=p.getGold_medal_count()+p.getSilver_medal_count()+p.getBrass_medal_count();
				Integer pai=i++;
				System.out.println(pai + "\t" + p.getCountry() + "\t" + p.getGold_medal_count() + "\t"
						+ p.getSilver_medal_count() + "\t" + p.getBrass_medal_count() + "\t"+sum);

			}
		}
}
