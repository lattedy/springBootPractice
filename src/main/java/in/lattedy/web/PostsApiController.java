package in.lattedy.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.lattedy.service.posts.PostsService;
import in.lattedy.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class PostsApiController {
	private final PostsService postsService;

	@PostMapping("/api/v1/posts")
	public long save(@RequestBody PostsSaveRequestDto requestDto) {
		return postsService.save(requestDto);
	}
}
