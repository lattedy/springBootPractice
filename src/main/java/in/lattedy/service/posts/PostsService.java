package in.lattedy.service.posts;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.lattedy.domain.posts.PostsRepository;
import in.lattedy.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostsService {
	private final PostsRepository postsRepository;

	@Transactional
	public Long save(PostsSaveRequestDto requestDto) {
		return postsRepository.save(requestDto.toEntity()).getId();
	}
}
