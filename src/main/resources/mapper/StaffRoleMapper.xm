<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.zhang.application.mapper.StaffRolesInfoMapper">
    <select id="getRolesByStaffId" parameterType="int" resultType="com.zhang.application.Entity.StaffRole" >
    select
    id,
    staff_id as staffId,
    role_id as roleId

    from staff_role where
    staff_id = #{staffId}
    </select>



</mapper>