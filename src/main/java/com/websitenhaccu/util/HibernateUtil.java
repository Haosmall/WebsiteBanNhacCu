package com.websitenhaccu.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.websitenhaccu.entity.QuangCao;
import com.websitenhaccu.entity.Attribute;
import com.websitenhaccu.entity.AttributeValue;
import com.websitenhaccu.entity.ThuongHieu;
import com.websitenhaccu.entity.DanhMuc;
import com.websitenhaccu.entity.BinhLuan;
import com.websitenhaccu.entity.LienHe;
import com.websitenhaccu.entity.GiamGia;
import com.websitenhaccu.entity.QuanHuyen;
import com.websitenhaccu.entity.GioiTinh;
import com.websitenhaccu.entity.HoaDon;
import com.websitenhaccu.entity.ChiTietHoaDon;
import com.websitenhaccu.entity.ChiTietHoaDon_PK;
import com.websitenhaccu.entity.SanPham;
import com.websitenhaccu.entity.DongSanPham;
import com.websitenhaccu.entity.TinhThanh;
import com.websitenhaccu.entity.NhaCungCap;
import com.websitenhaccu.entity.NguoiDung;
import com.websitenhaccu.entity.PhuongXa;

public class HibernateUtil {

	private static HibernateUtil instance = null;
	private static SessionFactory sessionFactory;

	private HibernateUtil() {

		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		Metadata metadata = new MetadataSources(registry)
                .addAnnotatedClass(QuangCao.class)
                .addAnnotatedClass(Attribute.class)
                .addAnnotatedClass(AttributeValue.class)
                .addAnnotatedClass(AttributeValue.class)
                .addAnnotatedClass(ThuongHieu.class)
                .addAnnotatedClass(DanhMuc.class)
                .addAnnotatedClass(BinhLuan.class)
                .addAnnotatedClass(BinhLuan.class)
                .addAnnotatedClass(LienHe.class)
                .addAnnotatedClass(GiamGia.class)
                .addAnnotatedClass(GioiTinh.class)
                .addAnnotatedClass(HoaDon.class)
                .addAnnotatedClass(ChiTietHoaDon.class)
                .addAnnotatedClass(ChiTietHoaDon_PK.class)
                .addAnnotatedClass(SanPham.class)
                .addAnnotatedClass(DongSanPham.class)
                .addAnnotatedClass(NhaCungCap.class)
                .addAnnotatedClass(NguoiDung.class)
                .addAnnotatedClass(TinhThanh.class)
                .addAnnotatedClass(QuanHuyen.class)
                .addAnnotatedClass(PhuongXa.class)
				.getMetadataBuilder()
				.build();
		sessionFactory = metadata.getSessionFactoryBuilder().build();

	}

	public synchronized static HibernateUtil getInstance() {
		if (instance == null)
			instance = new HibernateUtil();
		return instance;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public static void main(String[] args) {
		new HibernateUtil();
	}
}
