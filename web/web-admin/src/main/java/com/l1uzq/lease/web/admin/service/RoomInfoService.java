package com.l1uzq.lease.web.admin.service;

import com.l1uzq.lease.model.entity.RoomInfo;
import com.l1uzq.lease.web.admin.vo.room.RoomDetailVo;
import com.l1uzq.lease.web.admin.vo.room.RoomItemVo;
import com.l1uzq.lease.web.admin.vo.room.RoomQueryVo;
import com.l1uzq.lease.web.admin.vo.room.RoomSubmitVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author liubo
* @description 针对表【room_info(房间信息表)】的数据库操作Service
* @createDate 2023-07-24 15:48:00
*/
public interface RoomInfoService extends IService<RoomInfo> {

    void saveOrUpdateRoom(RoomSubmitVo roomSubmitVo);

    IPage<RoomItemVo> pageRoomItemByQuery(IPage<RoomItemVo> page, RoomQueryVo queryVo);

    RoomDetailVo getRoomDetailById(Long id);

    void removeRoomById(Long id);
}
