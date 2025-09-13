package com.squadmind.squad.mapper;

import com.squadmind.squad.dto.TagDTO;
import com.squadmind.squad.entity.Tag;

public class TagMapper {
    public static TagDTO toDTO(Tag tag){
        if (tag == null) return null;
        return new TagDTO(tag);
    }

    public static Tag toEntity(TagDTO tagDTO){
        if (tagDTO == null) return null;
        Tag tag = new Tag();
        tag.setId(tagDTO.getId());
        tag.setNomeTag(tagDTO.getNomeTag());
        tag.setSigla(tagDTO.getSigla());
        return tag;
    }
}
