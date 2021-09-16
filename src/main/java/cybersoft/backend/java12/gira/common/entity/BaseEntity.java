package cybersoft.backend.java12.gira.common.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;

import cybersoft.backend.java12.gira.common.util.DateUtils;
import lombok.Getter;
import lombok.Setter;

@Getter // sử dụng lambok
@Setter // sử dụng lambok
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class) // để JpaAuditing biết lớp BaseEntity này cần được tự động update những cột nào
public class BaseEntity {                      // AuditingEntityListener.class => class mặc định có sẵn
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false)
	protected Long id; 
	
	@Version
	protected int version;
	
	@CreatedBy
	protected String createdBy;
	
	@CreatedDate
	@LastModifiedDate
	@DateTimeFormat(pattern = DateUtils.DATE_FORMAT) 
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateUtils.DATE_FORMAT ) 
	protected LocalDateTime createdAt;
	
	@LastModifiedBy
	protected String updateBy;
	
	@LastModifiedDate
	@DateTimeFormat(pattern = DateUtils.DATE_FORMAT) // setup để dưới database hiện theo ý
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateUtils.DATE_FORMAT ) // setup để json hiện theo ý
	protected LocalDateTime updateAt;
	
	
}
