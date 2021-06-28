package br.com.wa.usecase.user.implementation;

import br.com.wa.domain.user.DataBaseSequence;
import br.com.wa.domain.user.User;
import br.com.wa.http.domain.request.UserRequest;
import br.com.wa.http.domain.response.UserResponse;
import br.com.wa.services.SequenceGeneratorService;
import br.com.wa.services.UserServices;
import br.com.wa.usecase.user.SaveUser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveUserImp implements SaveUser {

    @Autowired
    SequenceGeneratorService sequence;
    @Autowired
    private UserServices userServices;

    @Override
    public UserResponse execute(UserRequest request) {
        var userResponse = new UserResponse(new ModelMapper().map(request, User.class));
        var user = userResponse.getUser();
        user.setId(findNextSequence(User.SEQUENCE_NAME).getSequenceValue());
        userServices.save(user);
        return userResponse;
    }

    @Override
    public DataBaseSequence findNextSequence(String sequenceName) {
        return sequence.getNextSequence(sequenceName);
    }

}