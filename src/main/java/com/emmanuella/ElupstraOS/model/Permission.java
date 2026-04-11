package com.emmanuella.ElupstraOS.model;

import jakarta.persistence.*;
import lombok.*;
import jakarta.persistence.Id;
import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "permissions")
public class Permission extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(unique = true,nullable = false)
    private String name;
}
