package in.lattedy.service.posts;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.lattedy.domain.posts.Posts;
import in.lattedy.domain.posts.PostsRepository;
import in.lattedy.web.dto.PostsResponseDto;
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

	@Transactional
	public Long update(Long id, PostsSaveRequestDto requestDto) {
		Posts posts = postsRepository.findById(id)
			.orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다.\nid=" + id));

		posts.update(requestDto.getTitle(), requestDto.getContent());

		return id;
	}

	public PostsResponseDto findById(Long id) {
		Posts entity = postsRepository.findById(id)
			.orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다.\nid=" + id));

		return new PostsResponseDto(entity);
	}
}
